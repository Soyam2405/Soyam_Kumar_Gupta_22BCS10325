//lt 42
public class trappedRainwater {

    public static int trap(int[] heights){
        int n = heights.length;
        //left array
        int leftarr[] = new int[n];
        leftarr[0] = heights[0];
        for(int i =1; i<n; i++){
            leftarr[i] = Math.max(heights[i],leftarr[i-1] );
        }
        //right array
        int rightarr[] = new int[n];
        rightarr[n-1] = heights[n-1];
        for(int i = n-2; i>= 0; i--){
            rightarr[i] = Math.max(heights[i], rightarr[i+1]);
        }
        //trappedwater
        int trappedwater=0;
        for(int i=0; i<n; i++){
            //waterlevel
           int waterlevel = Math.min(leftarr[i],rightarr[i]);
           //trappedwatervolume
           trappedwater += waterlevel - heights[i];
        } 
        
        return trappedwater;     
    }
    public static void main(String[] args) {
        int[] heights = {4,2,0,6,2,3,5};
        //trap(heights);
        System.out.println(trap(heights));
    }
}
