/**
 *  @author Carolina Martinez 
 *  
 *  En esta clase se codifica el metodo de borrado en un árbol binario de busqueda.
 */
package ee_t06_borraAVL;
 public class ArbolAVL<T extends Comparable<T>>{
    NodoAVL <T> raiz;
 
    public ArbolAVL() {
		this.raiz = null;
	}

	public NodoAVL<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoAVL<T> raiz) {
		this.raiz = raiz;
	}
	
	public void eliminabalanceado(NodoAVL <T> nodo, Boolean bo, T infor){

		/**
		NODO: variable de tipo puntero (por referencia). 
		BO: variable de tipo booleano (por referencia) , indica que la altura del árbol ha disminuido, su valor inicial es falso. 
		INFOR es una variable  que contiene la información del elemento que quiere eliminarse
		OTRO es una variable auxiliar de tipo puntero
		*/

		bo =false;
		NodoAVL <T> otro= null;

		if(nodo != null){
		   if (infor.compareTo(nodo.getDato()) < -1){ 
		       eliminabalanceado(nodo.getIzq(), bo, infor);
		       restructura1(nodo, bo);
		} else{
			 if (infor.compareTo(nodo.getDato()) > 1){ 
		         eliminabalanceado(nodo.getDer(), bo, infor);
		         restructura2(nodo, bo);
		        } else{
		            otro=nodo;
		            if(otro.getDer() == null){
		               nodo=otro.getIzq();
		              }else{
		                 if(otro.getIzq() == null){
		                    nodo=otro.getDer();
		                    }else{
		                      borra(otro.getIzq(),otro,bo);
		                            restructura1(nodo,bo);
		                            //quita(otro);
		                            otro=null;
		                            }
		                           }
		                          }
		                         }
		                        }
		                          else
		                             System.out.println("El nodo no se encuentra en el arbol");
		}


		/**
		El algoritmo restructura el árbol cuando la altura de la rama izquierda ha disminuido y el FE de nodo es igual a 1.
		*/

		public void restructura1(NodoAVL<T> nodo, Boolean bo){
		/**
		NODO: variable de tipo puntero (por referencia). 
		BO: variable de tipo booleano (por referencia). Indica que  la altura de la rama izquierda ha disminuido
		NODO1 y NODO2 son variables auxiliares de tipo puntero
		*/
		 NodoAVL<T> nodo1, nodo2;


		if(bo = true){
		   if(nodo.getFe()== -1){
		      nodo.setFe(0);	
		      }else
		         if(nodo.getFe()  == 0){
		             nodo.setFe(1);
		             bo = false;
		            }else
		               if(nodo.getFe()  == 1){ // restructuración del árbol
		                  nodo1=nodo.getDer();
		                 if(nodo1.getFe()==0){ //ROTACION DD
		                    nodo.setDer(nodo.getIzq());
		                    nodo.setIzq(nodo);
		                    if(nodo1.getFe()==0){
		                       nodo.setFe(1);
		                       nodo1.setFe(-1);
		                       bo=false;
		                      }else
		                         if(nodo1.getFe()==1){
		                            nodo.setFe(0);
		                            nodo1.setFe(0);  
		                            }
		                             nodo=nodo1;
		                             }
		//TERMINA LA ROTACION DD
		                           else{   //ROTACION DI
		                               nodo2 = nodo1.getIzq();
		                               nodo.setDer(nodo2.getIzq());
		                               nodo2.setIzq(nodo);
		                               nodo1.setIzq(nodo2.getDer());
		                               nodo2.setDer(nodo1);
		                               if( nodo2.getFe() == 1){
		                                  nodo.setFe(-1);
		                                  }else{
		                                       nodo.setFe(0);
		                                       }
		                                       if(nodo.getFe()==-1){
		                                          nodo1.setFe(1);
		                                          }else{
		                                                nodo1.setFe(0); 
		                                                }
		                                                 nodo=nodo2;
		                                                 nodo2.setFe(0);
		//TERMINA LA ROTACION DI
		                                                 }
		                                               }               
		                                             }
		}

	

		/**
		El algoritmo restructura el árbol cuando la altura de la rama derecha ha disminuido y el FE de nodo es igual a 1. 
		*/
		public void restructura2(NodoAVL<T> nodo, Boolean bo){
		/**
		NODO : variable de tipo puntero (por referencia). 
		BO: variable de tipo booleano (por referencia). BO se utiliza para indicar que la altura de la rama izquierda ha disminuido
		NODO1 y NODO2:variables auxiliares de tipo puntero
		*/
		NodoAVL<T> nodo1, nodo2;

		if(bo==true){
		   if(nodo.getFe()  == 1){
		      nodo.setFe(0);
		      }else
		         if(nodo.getFe() == 0)
		            nodo.setFe(-1);
		            bo = false;
		            } else
		                if(nodo.getFe()  == -1){ // restructuración del árbol
		                   nodo1=nodo.getIzq();
		                   if(nodo1.getFe()<=0){  //ROTACION II
		                   nodo.setIzq(nodo1.getDer());
		                   nodo.setDer(nodo);
		                   if(nodo1.getFe() == 0){ 
		                      nodo.setFe(-1);
		                      nodo1.setFe(1);
		                      bo = false;
		                      }else
		                         if(nodo1.getFe() == -1){ 
		                            nodo.setFe(0);
		                            nodo1.setFe(0);
		                            }
		                            nodo=nodo1;
		                             }//?                           
		                            
		//TERMINA ROTACION II
		                              else{  //ROTACION ID
		                                  nodo2 = nodo1.getDer();
		                                  nodo.setIzq(nodo2.getDer());
		                                  nodo2.setDer(nodo);
		                                  nodo1.setDer(nodo2.getIzq());
		                                  nodo2.setIzq(nodo1);
		                                 if( nodo2.getFe() == -1){
		                                    nodo.setFe(1);
		                                    } else{
		                                          nodo.setFe(0);
		                                          }
		                                          if( nodo2.getFe()== 1){
		                                             nodo1.setFe(-1);
		                                             }else{
		                                                  nodo1.setFe(0);
		                                                  }
		                                                   nodo=nodo2;
		                                                   nodo2.setFe(0);
		                                                   //TERMINA LA ROTACION ID
		                                                 }
		                                          }
		}

	

		/**
		El algoritmo sustituye el elemento que se desea eliminar por el que se encuentra mas a la derecha en el subarbol izquierdo. 
		*/

		public void borra(NodoAVL<T> aux, NodoAVL<T>  otro, Boolean bo){
		/**
		 AUX y OTRO: variables de tipo puntero (ambas, por referencia). 
		BO es una variable de tipo booleano (por referencia)
		*/

		if(aux.getDer() != null){
		   borra(aux.getDer(), otro, bo);
		   restructura2(aux,bo);
		   }else
		       otro.setDato(aux.getDato());
		       aux =(NodoAVL<T>) aux.getIzq();
		       bo = true;
		}

		}



