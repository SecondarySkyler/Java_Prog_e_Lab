    import huffman_toolkit.*;
    import java.util.*;
    
    public class TextAnalysis {
        
        private static final int CHARS = InputTextFile.CHARS;
        
        public static void table (String src, String dst) {
        InputTextFile in = new InputTextFile( src );
        OutputTextFile out = new OutputTextFile( dst );
        
        int[] freq = Huffman.charHistogram(src);
        Node root = Huffman.huffmanTree (freq);
        String[] codes = Huffman.huffmanCodesTable (root);
        
        int size = root.weight();
        out.writeTextLine ("" + size);
        out.writeTextLine("CODICE ASCII" + "\t" + "CARATTERE" + "\t" + "OCCORRENZE" +"\t" + "CODICE HUFFMAN" + "\t" + "LUNGHEZZA");
        
        for (int i=0; i<CHARS; i++) {
            if (freq[i] == 0) {
            i = i;
            } else if (i == 9) {
                String code = codes[i];
                int l = codes[i].length();
                String row = "\t" + i + "\t" + "\\t" + "\t\t" + freq[i] + "\t\t" + code + "\t\t\t" + l;
                out.writeTextLine(row);
            }  else if (i == 10) {
                String code = codes[i];
                int l = codes[i].length();
                String row = "\t" + i + "\t" + "\\n" + "\t\t" + freq[i] + "\t\t" + code + "\t\t\t" + l;
                out.writeTextLine(row);
            }   else if (i == 13) {
                String code = codes[i];
                int l = codes[i].length();
                String row = "\t" + i + "\t" + "\\r" + "\t\t" + freq[i] + "\t\t" + code + "\t\t\t" + l;
                out.writeTextLine(row);
            }   else {
                char c = (char) i; //converte codisce ascii nel simbolo
                String code = codes[i];
                int l = codes[i].length();
                String row = "\t" + i + "\t" + c + "\t\t" + freq[i] + "\t\t" + code + "\t\t\t" + l;
                out.writeTextLine (row);
            }
        }
        out.close();    
       }
        
        // PARTE 2
       public static void generator (String dst) {
        OutputTextFile out = new OutputTextFile(dst);
        
        for (int i=0; i<=2790 ; i++){
            out.writeChar((char)(Math.random()*128));
        }
        out.close();
      }
        
        //PARTE 3
        public static int byteDimension(String src) {
        int result = 0;
        int[] freq = Huffman.charHistogram(src);
        Node root = Huffman.huffmanTree(freq);
        String[] codes = Huffman.huffmanCodesTable(root);
        
        for (int i = 0; i < CHARS; i++) {
            if (freq[i] == 0) {
                i = i;
            }else {
                result = (result + (freq[i] * codes[i].length())) / 8;
            }
        }
        return result;
       }    
}// class TextAnalysis