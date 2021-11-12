import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DAGLCA {
	
	
	private int V;
    public LinkedList<Integer>adj[];
	
	DAGLCA (int v) 
	{
		V=v;
        adj = new LinkedList[V];  
        for (int i=0; i<v; ++i)
        adj[i] = new LinkedList<Integer>();
	}
 
     void addEdge(int u, int v)
     {
         adj[u].add(v);// Add v to u's list
     }
        
        private List<Integer> lowestPath1 = new ArrayList<>();
        private List<Integer> lowestPath2 = new ArrayList<>();
        
        public int findLCA(int root, int n1, int n2)
        {
        	lowestPath1.clear();
        	lowestPath2.clear();
        	return findLCAInternal(root,n1,n2);
        }
        
        private int findLCAInternal(int root, int n1, int n2)
        {
        	if(!findPath(root,n1,lowestPath1) || !findPath(root,n2,lowestPath2))
        	{
        		return -1;
        	}
        	
        	int i;
            for (i = 0; i < lowestPath1.size() && i < lowestPath2.size(); i++) {
                 
            // System.out.println(path1.get(i) + " " + path2.get(i));
                if (!lowestPath1.get(i).equals(lowestPath2.get(i)))
                    break;
            }
     
            return lowestPath1.get(i-1);
        }
        
        private boolean findPath(int root, int n, List<Integer> lowestPath)
        {
        	lowestPath.add(root);
        	
        	if(root == n)
    		{
    			return true;
    		}
        	for(int i=0; i<adj[root].size(); i++)
        	{
        		if(findPath(adj[root].get(i),n,lowestPath))
        		{
        			return true;
        		}
        	}
        	lowestPath.remove(lowestPath.size()-1);
        	
        	return false;
        	
        }
        
        
    
}
