public class Dragon {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]) ;
        String n1 = "F" ;
        for( int i = 2 ; i <= n ; i++){
            String n2 = Daoxau(n1) ;
            n1 += "L" ;
            n1 += n2 ;
        }
        System.out.print(n1) ;
    }
    private static String Daoxau(String n1) {
        StringBuilder a = new StringBuilder(n1) ;
        int  len = n1.length() ;
        for ( int j = len - 1 ; j >= 0 ; j-- ){
            a.setCharAt(len - 1 - j , n1.charAt(j));
        }
        for (int i = 0 ; i < len ; i++){
            if (a.charAt(i) == 'R'){
                a.setCharAt(i , 'L');
            }
            if (a.charAt(i) == 'L'){
                a.setCharAt(i,'R');
            }
        }
        return a.toString() ;
    }
}
