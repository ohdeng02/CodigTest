class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answer[]=new int[commands.length];
        int[] arr2 = {};
        
        for(int i = 0; i<commands.length; i++) {
        	int x = commands[i][0];
            int y = commands[i][1];
            int z = commands[i][2];
        	arr2 = new int[y-x+1];
        	
        	int start = x;
        	for(int j = 0; j<y-x+1; j++) {
        		arr2[j] = array[start-1];
        		start++;
        	}
        	for(int l = 0; l<arr2.length-1; l++) {
        		for(int k = l+1; k<arr2.length; k++) {
        			if(arr2[l]>arr2[k]) {
        				int temp = arr2[l];
        				arr2[l] = arr2[k];
        				arr2[k] = temp;
        			}
        		}
        	}
        	answer[i]=arr2[z-1];
        }    
        return answer;
	}

}