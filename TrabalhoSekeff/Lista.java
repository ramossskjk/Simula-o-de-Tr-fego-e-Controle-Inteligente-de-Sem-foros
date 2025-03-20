class Lista<T> {
    class NoLista {
        T valor;
        NoLista proximo;

        public NoLista(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private NoLista cabeca;

    public void adicionar(T valor) {
        NoLista novoNo = new NoLista(valor);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            NoLista atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public T obter(int indice) {
        NoLista atual = cabeca;
        for (int i = 0; i < indice; i++) {
            if (atual == null) throw new IndexOutOfBoundsException();
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public int tamanho() {
        int tamanho = 0;
        NoLista atual = cabeca;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }
}