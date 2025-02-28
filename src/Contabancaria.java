abstract class ContaBancaria {
    protected String numeroConta;
    protected String titular;
    protected double saldo;

    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado. Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public abstract void sacar(double valor);

    public void exibirInformacoes() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}

class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double saldoDisponivel = saldo + limiteChequeEspecial;
        if (valor <= saldoDisponivel) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
        }
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Limite do Cheque Especial: R$ " + limiteChequeEspecial);
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}

class ContaInvestimento extends ContaBancaria {
    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.02;
        if (valor + taxa <= saldo) {
            saldo -= (valor + taxa);
            System.out.println("Saque de R$ " + valor + " realizado com taxa de R$ " + taxa + ". Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque com taxa.");
        }
    }
}

class ContaSalario extends ContaCorrente {
    private int saquesGratuitos;
    private int saquesRealizados;

    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
        this.saquesGratuitos = 1; 
        this.saquesRealizados = 0;
    }

    @Override
    public void sacar(double valor) {
        double taxa = 0;
        if (saquesRealizados >= saquesGratuitos) {
            taxa = 5.0;
        }

        double saldoDisponivel = saldo + limiteChequeEspecial;
        if (valor + taxa <= saldoDisponivel) {
            saldo -= (valor + taxa);
            saquesRealizados++;
            System.out.println("Saque de R$ " + valor + " realizado. Taxa: R$ " + taxa + ". Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
        }
    }
}

class ContaInvestimentoAltoRisco extends ContaInvestimento {
    private static final double SALDO_MINIMO = 10000.0;

    public ContaInvestimentoAltoRisco(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.05; 
        if (saldo >= SALDO_MINIMO && valor + taxa <= saldo) {
            saldo -= (valor + taxa);
            System.out.println("Saque de R$ " + valor + " realizado com taxa de R$ " + taxa + ". Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente ou abaixo do mínimo exigido para saque.");
        }
    }
}
