**Program description**:
This program performs a depth-first search on a given input, measures time taken to access each node and overall performance of depth-first search. 
It also uses topological sort to print it in the right order. Expected limitations of the program include the size of the file that is used as an input. 

**Program design**:
- The App class served as a driver class to test given algorithms. 
- The Graph class include all the needed algorithms as well as methods to print the output. 

**Method description**:

public boolean DFS(int v) 
- a method that contains algorithm needed to perform depth-first search. DFS visits all the nodes to its depth, before visiting its neighbours. The boolean black used in this algorithm serves as an indicator if certain node was visited. 

public void topologicalSort()
- method that performs the topological sort. 

public void topSortHelper(int v, boolean black[], Stack stack)
- a helper method for topologicalSort method that iterates through the input and pushes on stack visited nodes. 


 
