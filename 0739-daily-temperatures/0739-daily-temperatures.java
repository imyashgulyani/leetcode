class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] a=new int[temperatures.length];
        stack.push(0);
        for(int i=1;i<temperatures.length;i++)
        {
            int current_temp=temperatures[i];
            while(!stack.isEmpty())
            {
                int b=stack.peek();
                int temp_top=temperatures[b];
                if(temp_top<current_temp)
                {
                    a[b]=i-b;
                    stack.pop();
                }
                else
                {
                    break;
                }
            }
            stack.push(i);
        }
        return a;
    }
}