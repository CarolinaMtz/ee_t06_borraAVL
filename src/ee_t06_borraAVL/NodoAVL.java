/**
 *  @author Carolina Martinez 
 *  
 *  En esta clase se codifica la clase Nodo, que contiene dos nodos,
 *  un nodo derecho y otro izquierdo, el dato a ingresarse, asi como tambien
 *  un factor de equilibrio, que es el que nos ayudará a saber si el arbol
 *  está o no equilibrado, (la altura del arbol).
 */
package ee_t06_borraAVL;

public class NodoAVL <T>{
	T dato;
	NodoAVL <T> izq;
	NodoAVL <T> der;
	Integer fe; //FACTOR DE EQUILIBRIO
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoAVL<T> getIzq() {
		return izq;
	}
	public void setIzq(NodoAVL<T> izq) {
		this.izq = izq;
	}
	public NodoAVL<T> getDer() {
		return der;
	}
	public void setDer(NodoAVL<T> der) {
		this.der = der;
	}
	public Integer getFe() {
		return fe;
	}
	public void setFe(Integer fe) {
		this.fe = fe;
	}
	
	public NodoAVL(T dato) {
		this.dato = dato;
		izq = der= null;
		fe = 0;
	}

}

