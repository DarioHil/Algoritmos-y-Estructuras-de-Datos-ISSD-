package Desempenio_de_sintesis;

public class Desempenio_de_sintesis {

        class nodo
        {
                int info;
                nodo sig, ant;
        }
        
        
        private nodo raiz;
        	public Desempenio_de_sintesis()
        	{
                raiz= null;
        	}
        	
        	
        	public int cantidad () 
        	{
                int cant = 0;
                nodo reco = raiz;
                while (reco!=null) 
                {
                      reco = reco.ant;
                      cant ++;
                }
                return cant;
        	}
        	
        	
        public void insertar (int x, int a) 
        {
                nodo nuevo = new nodo();
                nodo nuevodos = new nodo();
                nuevo.info = x;
                nuevodos.info = a;
                if (raiz == null) 
                {
                        raiz = nuevo;
                        nuevo.ant = nuevodos;
                        nuevodos.sig =nuevo;
                        
                } else
                if (cantidad() == 4) 
                {
                        nodo reco = raiz;
                        while (reco.ant != null) 
                        {
                                reco = reco.ant;
                        }
                        
                        reco.ant = nuevo;
                        nuevo.sig = reco;
                        nuevo.ant = nuevodos;
                        nuevodos.sig = nuevo;
                        nuevodos.ant = null;
                } else 
                	
                {
                        raiz.sig = nuevodos;
                        nuevodos.ant = raiz;
                        nuevodos.sig = nuevo;
                        nuevo.ant = nuevodos;
                        raiz = nuevo;
                        raiz.sig = null;
                }
        }
        
        
        
        public void mostrar () 
        {
                
                if (raiz != null) {
                nodo reco = raiz;
                nodo recodos = raiz.ant;
                while (reco != null)
                {
                        if (reco.ant == null) 
                        {
                                System.out.print(reco.info+".");
                                reco = reco.ant;
                        } else 
                        	
                        {
                                        System.out.print(reco.info+"-");
                                        reco = reco.ant;
                                  }
                }
                }
                else 
                {
                        System.out.println("No hay elementos para mostrar. ");
                }
                System.out.println();
        }
        
        
        public void SumaImpares() 
        {
                System.out.print("Respuesta pregunta N°2: ");
                nodo reco = raiz;
                int suma = 0;
                int detectar = 0;
                while (reco != null) 
                {
                        detectar = detectar +1;
                        if (detectar%2 == 0)
                        	
                        {
                        reco = reco.ant;
                        } else 
                        	
                        {
                                suma = suma + reco.info;
                                reco = reco.ant;
                        }
                }
                System.out.println();
                System.out.println("la suma de los nodos impares es: "+suma);
        }
        
        
        
        public void borrarPrimero() 
        {
                if (raiz != null) {
                        if (raiz.ant != null ) {
                        nodo nuevo = raiz;
                        nodo nuevodos = raiz.ant;
                        nuevo = nuevo.ant;
                        nuevodos = nuevodos.ant;
                        raiz = nuevo;
                        nuevo.sig = null;
                        } else 
                        	
                        {
                                raiz = null;    
                        }
                }
                                
        }
        
        
        
        
        public void borrarUltimo() 
        {
                if (raiz !=null) {
                if (raiz.ant != null) {
                nodo reco = raiz;
                nodo nuevo = raiz;
                
                while (reco.ant != null) 
                {
                        reco = reco.ant;
                }
                
                nuevo = reco.sig;
                reco.sig = null;
                nuevo.ant = null;
                }
                else 
                	
                {
                        raiz = null;
                
                }
                }
        }
        
        
        public void borrarElementos() 
        {
                System.out.println("Respuesta pregunta N°3: ");
                borrarPrimero();
                borrarUltimo();
                mostrar();
        }
        
        
        
        
        public void CambiarDeLugar() 
        {
                if (cantidad()<2) 
                {
                        System.out.println("No hay suficientes elementos para intercambiar. ");
                }else if( cantidad()==2)
                {
                        nodo reco = raiz.ant;
                        raiz.sig = reco;
                        reco.ant = raiz;
                        raiz.ant = null;
                        raiz = reco;
                        raiz.sig= null;
                } else{
                        System.out.println("Respuesta pregunta N°4: ");
                        nodo aux = raiz;
                        nodo recodos = raiz;
                        
                        
                        while (recodos.ant != null) 
                        {
                                recodos = recodos.ant;
                        }
                        recodos.ant = raiz;
                        raiz = raiz.ant;
                        raiz.sig = null;
                        aux.sig = recodos;
                        aux.ant = null;
                        
                        recodos.ant.ant = null;
                        recodos.sig.ant = recodos.ant;
                        recodos.ant.sig = recodos.sig;
                        recodos.sig = null;
                        recodos.ant = raiz;
                        raiz.sig = recodos;
                        raiz = recodos;
                        
                }
                mostrar();
                                
        }
        
        
        public void borrarCoincidencias() 
        {
                System.out.println("Respuesta pregunta N°5: ");
                nodo reco = raiz.ant;
                int con = raiz.info;
                nodo aux = raiz;
                nodo auxdos = raiz;
                
                while (reco != null) 
                {
                        
                        if (reco.info == con) 
                        {
                                if (reco.ant != null) {
                                aux = reco.ant;
                                
                                auxdos = reco.sig;
                                aux.sig = auxdos;
                                auxdos.ant = aux;
                                }else 
                                {
                                        reco.sig.ant = null;
                                        reco.sig = null;
                                }
                                
                                reco = raiz;
                        }
                        
                        reco = reco.ant;
                }                mostrar();
        }
        
        
        
        public static void main (String[]ar) 
        {
        		Desempenio_de_sintesis p = new Desempenio_de_sintesis();
                p.insertar(10, 20);
                p.insertar(5, 200);
                p.insertar(200, 4);
                p.insertar(1, 2);               
                
                System.out.println ("Respuesta pregunta N°1: ");
                p.mostrar();
                System.out.println();
                p.SumaImpares();
                System.out.println();
                p.borrarElementos();
                System.out.println();
                p.CambiarDeLugar();
                System.out.println();
                p.borrarCoincidencias();
                
                
                
        }
        
}
