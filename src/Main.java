public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "João Silva", 1000, 500);
        contaCorrente.exibirInformacoes();
        contaCorrente.sacar(1200);
        contaCorrente.sacar(400);  
        System.out.println();

        
        ContaPoupanca contaPoupanca = new ContaPoupanca("67890", "Maria Oliveira", 2000);
        contaPoupanca.exibirInformacoes();
        contaPoupanca.sacar(2500); 
        contaPoupanca.sacar(1500); 
        System.out.println();

        
        ContaInvestimento contaInvestimento = new ContaInvestimento("54321", "Carlos Souza", 5000);
        contaInvestimento.exibirInformacoes();
        contaInvestimento.sacar(1000); 
        System.out.println();

        ContaSalario contaSalario = new ContaSalario("98765", "Ana Costa", 800, 300);
        contaSalario.exibirInformacoes();
        contaSalario.sacar(200);
        contaSalario.sacar(100); 
        System.out.println();

        ContaInvestimentoAltoRisco contaAltoRisco = new ContaInvestimentoAltoRisco("11223", "Pedro Alves", 15000);
        contaAltoRisco.exibirInformacoes();
        contaAltoRisco.sacar(5000); 
        contaAltoRisco.sacar(20000); 
    }
}
