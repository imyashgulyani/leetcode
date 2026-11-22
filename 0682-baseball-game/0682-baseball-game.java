class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> stack=new Stack<>();
        int totalsum=0;
        for(String a:operations)
        {
            if(a.equals("C") && !stack.isEmpty())
            {
                totalsum-=stack.pop();
            }
            else if(a.equals("D"))
            {
                stack.push(stack.peek()*2);
                totalsum+=stack.peek();
            }
            else if(a.equals("+"))
            {
                int lastscore=stack.pop();
                int secondlastscore=stack.peek();
                int sum=lastscore+secondlastscore;
                stack.push(lastscore);
                stack.push(sum);
                totalsum+=stack.peek();
            }
            else
            {
                stack.push(Integer.parseInt(a));
                totalsum+=stack.peek();
            }
        }
        return totalsum;
    }
}