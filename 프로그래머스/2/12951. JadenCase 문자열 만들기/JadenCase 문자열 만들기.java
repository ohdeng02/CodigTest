class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ");
        String result = "";
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()==0) result+=" ";
            else{
                arr[i]=arr[i].substring(0,1).toUpperCase()+arr[i].substring(1, arr[i].length()).toLowerCase();            
                result += arr[i];
                if(i != arr.length-1) result+= " ";
            }
        }
        if(s.charAt(0)==' ') result = " "+result;
        else if(s.charAt(s.length()-1)==' ') result+=" ";
        return result;
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i].length()!=0){
        //         String a = arr[i].substring(0,1).toUpperCase()+arr[i].substring(1, arr[i].length()).toLowerCase();
        //         s = s.replaceAll(arr[i], a);
        //     }
        // }
        // return s;
    }
}