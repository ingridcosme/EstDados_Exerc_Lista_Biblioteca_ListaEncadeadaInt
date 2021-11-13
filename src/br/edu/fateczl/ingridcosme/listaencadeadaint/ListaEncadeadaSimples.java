package br.edu.fateczl.ingridcosme.listaencadeadaint;

public class ListaEncadeadaSimples {
	No cabeca;
	No cauda;
	
	public ListaEncadeadaSimples() {
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
		System.out.println("");
		System.out.print("NULL<==");
		while(auxiliar != null) {
			System.out.print("[][ " + auxiliar.dado + " ][]<==>");
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
	
	public boolean contains(int valor) {
		boolean achou = false;
		No auxiliar = cabeca;
		while (auxiliar != null) {
			if(auxiliar.dado == valor) {
				achou = true;
			}
			auxiliar = auxiliar.proximo;
		}
		return achou;
	}
	
	public boolean isBusy(int posicao) {
		boolean ocupado = false;
		if(posicao >= 0 && posicao < size()) {
			ocupado = true;
		}
		return ocupado;
	}
	
	public No getNo(int posicao) throws Exception {
		if(!isBusy(posicao)) {
			throw new Exception("Posição não existe");
		}
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		No auxiliar = cabeca;
		for(int i = 0; i <= posicao-1; i++) {
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}
	
	public int getValue(int posicao) throws Exception {
		return getNo(posicao).dado;
	}
	
	public void insertPosition(int posicao, int valor) throws Exception {
		if(posicao == 0) {
			insertAtFront(valor);
		} else {
			if(posicao == size() - 1) {
				insertAtBack(valor);
			} else {
				No anterior = getNo(posicao - 1);
				No novoNo = new No();
				novoNo.dado = valor;
				novoNo.proximo = anterior.proximo;
				anterior.proximo = novoNo;
			}
		}
	}
	
	public void removePosition(int posicao) throws Exception {
		if(posicao == 0) {
			removeAtFront();
		} else {
			if(posicao == size() - 1) {
				removeAtBack();
			} else {
				No removido = getNo(posicao);
				No anterior = getNo(posicao - 1);
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
