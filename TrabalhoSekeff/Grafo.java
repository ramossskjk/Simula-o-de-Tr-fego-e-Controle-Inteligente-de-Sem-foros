class Lista<T> {
    private class NoLista {
        @SuppressWarnings("unused")
        T dado;
        NoLista proximo;

        public NoLista(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private NoLista primeiro;

    public Lista() {
        this.primeiro = null;
    }

    public void adicionar(T dado) {
        NoLista novo = new NoLista(dado);
        if (primeiro == null) {
            primeiro = novo;
        } else {
            NoLista atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }
}
