package br.edu.fateczl.ingridcosme.listaencadeadaint;

public class ListaEncadeada {
	No cabeca;
	No cauda;
	
	public ListaEncadeada() {
		cabeca = null;
		cauda = null;
	}
	
	public boolean isEmpty() {
		if(cabeca == null && cauda == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insertAtBack(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		
		if(cabeca == null) {
			cabeca = elemento;
			cauda = elemento;
			elemento.proximo = null;
		} else {
			cauda.proximo = elemento;
			elemento.proximo = null;
			cauda = elemento;
		}
	}
	
	public void insertAtFront(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		
		if(cabeca == null) {
			cabeca = elemento;
			cauda = elemento;
			elemento.proximo = null;
		} else {
			elemento.proximo = cabeca;
			cabeca = elemento;
		}
	}
	
	public int removeAtFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		if(cabeca == cauda && cabeca != null) {
			cabeca = null;
			cauda = null;
		} else {
			cabeca = cabeca.proximo;
		}
		return auxiliar.dado;
	}
	
	public int removeAtBack() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cauda;
		if(cabeca == cauda && cauda != null) {
			cabeca = null;
			cauda = null;
		} else {
			No penultimo = cabeca;
			while(penultimo.proximo != cauda) {
				penultimo = penultimo.proximo;
			}
			cauda = penultimo;
			cauda.proximo = null;
		}
		return auxiliar.dado;
	}
	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		System.out.println("=============================================");
		while(auxiliar != null) {
			System.out.println("[ " + auxiliar.dado + " ] ==> ");
			auxiliar = auxiliar.proximo;
		}
		System.out.println("NULL");
		System.out.println("");
		System.out.println("=============================================");
	}
	
	public int size() {
		int cont = 0;
		if(!isEmpty()) {
			No auxiliar = cabeca;
			while(auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	public boolean contem(int valor) {
		boolean cont = false;
		No auxiliar = cabeca;
		while (auxiliar != null) {
			if(auxiliar.dado == valor) {
				cont = true;
			}
			auxiliar = auxiliar.proximo;
		}
		return cont;
	}
	
	public boolean posicaoOcupada(int posicao) {
		boolean ocupado = false;
		if(posicao >= 0 && posicao < size()) {
			ocupado = true;
		}
		return ocupado;
	}
	
	public No pegaNo(int posicao) throws Exception {
		if(!posicaoOcupada(posicao)) {
			throw new Exception("Posição não existe");
		}
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		for(int i = 0; i < posicao-1; i++) {
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}
	
	public int pegaElemento(int posicao) throws Exception {
		return pegaNo(posicao).dado;
	}
	
	public void adicionaPosicao(int posicao, int valor) throws Exception {
		if(posicao == 0) {
			insertAtFront(valor);
		} else {
			if(posicao == size() - 1) {
				insertAtBack(valor);
			} else {
				No anterior = pegaNo(posicao - 1);
				No novoNo = new No();
				novoNo.dado = valor;
				novoNo.proximo = anterior.proximo;
				anterior.proximo = novoNo;
			}
		}
	}
	
	public void remove(int posicao) throws Exception {
		if(posicao == 0) {
			removeAtFront();
		} else {
			if(posicao == size() - 1) {
				removeAtBack();
			} else {
				No removido = pegaNo(posicao);
				No anterior = pegaNo(posicao - 1);
				anterior.proximo = removido.proximo;
			}
		}
	}
	
	@Override
	public String toString() {
		int tamanho = size();
		if(tamanho == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = cabeca;
		for(int i = 0; i < tamanho - 1; i++) {
			builder.append(atual.dado);
			builder.append(", ");
			atual = atual.proximo;
		}
		builder.append(atual.dado);
		builder.append("]");
		return builder.toString();
	}
	
}
