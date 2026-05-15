public class Fila<E> {

    private Celula<E> sentinela;
    private Celula<E> tras;

    public Fila() {
        sentinela = new Celula<E>();
        tras = sentinela;
    }

    public boolean vazia() {
        return sentinela.getProximo() == null;
    }

    public void enfileirar(E item) {
        Celula<E> nova = new Celula<E>(item);
        tras.setProximo(nova);
        tras = nova;
    }

    public E desenfileirar() {
        if (vazia()) {
            throw new java.util.NoSuchElementException("Fila vazia");
        }
        Celula<E> frente = sentinela.getProximo();
        E item = frente.getItem();
        sentinela.setProximo(frente.getProximo());
        if (sentinela.getProximo() == null) {
            tras = sentinela;
        }
        return item;
    }

    public E consultarFrente() {
        if (vazia()) {
            throw new java.util.NoSuchElementException("Fila vazia");
        }
        return sentinela.getProximo().getItem();
    }

    /** Retorna os elementos da fila em ordem, sem modificar a fila */
    public java.util.List<E> elementos() {
        java.util.List<E> lista = new java.util.ArrayList<>();
        Celula<E> atual = sentinela.getProximo();
        while (atual != null) {
            lista.add(atual.getItem());
            atual = atual.getProximo();
        }
        return lista;
    }
}
