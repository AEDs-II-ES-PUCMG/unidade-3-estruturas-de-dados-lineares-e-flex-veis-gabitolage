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

    /**
     * Conta quantas ocorrências de um elemento existem na fila atual, sem modificar a fila.
     */
    public int contarOcorrencias(E elemento) {
        int contador = 0;
        Celula<E> atual = sentinela.getProximo();
        while (atual != null) {
            E item = atual.getItem();
            if (elemento == null) {
                if (item == null) contador++;
            } else {
                if (elemento.equals(item)) contador++;
            }
            atual = atual.getProximo();
        }
        return contador;
    }

    /**
     * Extrai os primeiros numItens elementos da fila atual (na ordem de chegada)
     * e os retorna em uma nova Fila. Caso a fila possua menos elementos, extrai os
     * disponíveis e esvazia a fila origem.
     */
    public Fila<E> extrairLote(int numItens) {
        Fila<E> lote = new Fila<>();
        if (numItens <= 0) return lote;

        for (int i = 0; i < numItens; i++) {
            if (this.vazia()) break;
            E item = this.desenfileirar();
            lote.enfileirar(item);
        }

        return lote;
    }
}
