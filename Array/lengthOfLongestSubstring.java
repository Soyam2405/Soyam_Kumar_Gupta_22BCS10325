class Solution {
    public int lengthOfLongestSubstring(String s) {
        int subStringLength = 0;
        int i = 0;
        int j = 0;

        List<Character> subStringList = new ArrayList<>();

        while(i < s.length()){
            if(!subStringList.contains(s.charAt(i))){
                subStringList.add(s.charAt(i));
                i++;
                subStringLength = Math.max(subStringLength, subStringList.size());
            }else{
                subStringList.remove(Character.valueOf(s.charAt(j)));
                j++;
            }
        }
        return subStringLength;
    }
}
