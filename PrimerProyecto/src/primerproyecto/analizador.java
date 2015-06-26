package primerproyecto;


public class analizador {
    
    String auxLexema;
    int contador;
    int estado=0;
    int contador1;
    int contador3;
    
   public void analizar(String entrada){
       entrada= entrada +"#";
       auxLexema="";
       char c;
       
       for(int i=0;i<entrada.length();i++){
           c=entrada.charAt(i);
           int codigotabla=c;
           switch(estado){
               
               case 0:
                   if(Character.isLetter(c)){
                       estado=1;
                       auxLexema+=c;
                       }break;
                  

               case 1:
                   if(Character.isLetter(c)){
                       estado=1;
                       auxLexema+=c;

                   }
                     else if(c=='\n'){
                        
                       contador++;
                       estado=1;
                        System.out.println("token---->"+auxLexema);
                       auxLexema="";
                      
                     //  i--;
                    break;
                        }
                     else if(c=='#'){
                     System.out.println("token---->"+auxLexema);
                       System.out.println(contador);
                       System.out.println(contador1);
                       System.out.println("Contador de error"+contador3);
                       break;
                        
                     }
                       else{
                           System.out.println("Error de lexema------>"+c);
                           
                          contador3++;
                       }
                       
                   break;
                   
               
           }
           contador1++;
       }
   }
           
    
}
