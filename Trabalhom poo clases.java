import java.util.ArrayList;
import java.util.List;


interface Alugar {
    public 
}

class Cliente {
    private String telefone;
    private String email;
    private String nome;
    private boolean inadimplente;
    private boolean cadastroRegular; 
    private double aluguel;
    
    public Cliente(String telefone, String email, String nome) {
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
    }
    
    public void exibirContato() {
        System.out.println("O número do Cliente é: " + telefone);
        System.out.println("O e-mail do Cliente é: " + email);
    }
}

class Estoque {
    private List<Item> listaDeItens;

    public Estoque() {
        this.listaDeItens = new ArrayList<>();
    }

    public void addItem(Item item) {
        listaDeItens.add(item);
        System.out.println("Item adicionado ao estoque!");
    }

    public void removerItem(Item item) {
        if (listaDeItens.remove(item)) {
            System.out.println("Item removido do estoque!");
        } else {
            System.out.println("Item não encontrado no estoque!");
        }
    }

    public void varrerVetor() {
        if (listaDeItens.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        
        System.out.println("ITENS EM ESTOQUE:");
        for (Item item : listaDeItens) {
            item.exibirDetalhes();
            System.out.println("----------------------------");
        }
    }
}

abstract class Item {
    private double qtd;
    private String ID;
    private String nome;
    private String SI;
    private String marca;
    private Cliente cliente;
    
    public Item(double qtd, String ID, String nome, String SI, String marca, Cliente cliente) {
        this.qtd = qtd;
        this.ID = ID;
        this.nome = nome;
        this.SI = SI;
        this.marca= marca;
        this.cliente = cliente;
    }
    
    protected void exibirBase() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Marca: " + marca);
        System.out.println("Qtd: " + qtd + " " + si);
    }
    
    public abstract void exibirDetalhes();

    public double adicionarQTD (int valor) {
        return qtd+= valor;
    }
    
    public void removerQTD (int valor) {
        if (valor <= qtd) {
            qtd-= valor;
            System.out.println("Quantidade adicionada ao Estoque (total: " + qtd + " " + SI + ")" );
        } else {
        System.out.println("Quantidade em estoque insuficiente!");
        }
    }
}

    

class Equipamento extends Item {
    private String precisao;
    private String garantia;
    private String numeroDeSerie;

    public Equipamento(double qtd, String id, String nome, String si, String marca, String precisao, String garantia, String numeroDeSerie) {
        super(preco, qtd, id, nome, si, marca);
        this.precisao = precisao;
        this.garantia = garantia;
        this.numeroDeSerie = numeroDeSerie;
    }

    public void exibirDetalhes() {
        System.out.println("--- Equipamento ---");
        exibirBase();
        System.out.println("Precisão: " + precisao);
        System.out.println("Garantia: " + garantia);
        System.out.println("Nº de série: " + numeroDeSerie);
    }
}

class Iluminacao extends Item {
    private double potencia;
    private String corTemperatura;
    private double tensao;

    public Iluminacao(double qtd, String id, String nome, String si, String marca, double potencia, String corTemperatura, double tensao) {
        super(preco, qtd, id, nome, si, marca);
        this.potencia = potencia;
        this.corTemperatura = corTemperatura;
        this.tensao = tensao;
    }

    public void exibirDetalhes() {
        System.out.println("--- Iluminação ---");
        exibirBase();
        System.out.println("Potência: " + potencia + " W");
        System.out.println("Cor/Temperatura: " + corTemperatura);
        System.out.println("Tensão: " + tensao + " V");
    }
}

class ProtecaoComando extends Item {
    private double corrente;
    private String curva;
    private int polos;

    public ProtecaoComando(double qtd, String id, String nome, String si, String marca, double corrente, String curva, int polos) {
        super(preco, qtd, id, nome, si, marca);
        this.corrente = corrente;
        this.curva = curva;
        this.polos = polos;
    }

    public void exibirDetalhes() {
        System.out.println("--- Proteção e Comando ---");
        exibirBase();
        System.out.println("Corrente: " + corrente + " A");
        System.out.println("Curva: " + curva);
        System.out.println("Polos: " + polos);
    }
}

class Cabos extends Item {
    private double secao;
    private String tipo;
    private String cor;

    public Cabos(double qtd, String id, String nome, String si, String marca, double secao, String tipo, String cor) {
        super(preco, qtd, id, nome, si, marca);
        this.secao = secao;
        this.tipo = tipo;
        this.cor = cor;
    }

    public void exibirDetalhes() {
        System.out.println("--- Cabos ---");
        exibirBase();
        System.out.println("Seção: " + secao + " mm²");
        System.out.println("Tipo: " + tipo);
        System.out.println("Cor: " + cor);
    }
}

class Passagem extends Item {
    private double diametro;
    private String material;
    private String tipo;

    public Passagem(double qtd, String id, String nome, String si, String marca, double diametro, String material, String tipo) {
        super(preco, qtd, id, nome, si, marca);
        this.diametro = diametro;
        this.material = material;
        this.tipo = tipo;
    }

    public void exibirDetalhes() {
        System.out.println("--- Passagem ---");
        exibirBase();
        System.out.println("Diâmetro: " + diametro + " mm");
        System.out.println("Material: " + material);
        System.out.println("Tipo: " + tipo);
    }
}

class Acabamento extends Item {
    private String design;
    private double corrente;

    public Acabamento(double qtd, String id, String nome, String si, String marca, String design, double corrente) {
        super(preco, qtd, id, nome, si, marca);
        this.design = design;
        this.corrente = corrente;
    }

    public void exibirDetalhes() {
        System.out.println("--- Acabamento ---");
        exibirBase();
        System.out.println("Design: " + design);
        System.out.println("Corrente: " + corrente + " A");
    }
}

public class Main {
    public static void main(String[] args) {
        Iluminacao lampada = new Iluminacao(10, "1", "Lâmpada LED", "UN", "Philips", 9.0, "Branca fria", 127);
        Cabos cabo = new Cabos(100, "2", "Cabo flexível", "M", "Sil", 2.5, "Flexível", "Azul");
        Acabamento tomada = new Acabamento(30, "3", "Tomada 2P+T", "UN", "Tramontina", "Branco", 10);

        lampada.exibirDetalhes();
        System.out.println();
        cabo.exibirDetalhes();
        System.out.println();
        tomada.exibirDetalhes();
    }
}
