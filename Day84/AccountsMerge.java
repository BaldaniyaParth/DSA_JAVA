package Day84;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        String [][] accountsArray = {{"John","johnsmith@mail.com","john_newyork@mail.com"},
                {"John","johnsmith@mail.com","john00@mail.com"},
                {"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};

        // Convert string array to List<List<String>>
        List<List<String>> accounts = new ArrayList<>();
        for (String[] account : accountsArray) {
            accounts.add(Arrays.asList(account));
        }

        // Merge accounts
        List<List<String>> mergedAccounts = accountsMerge(accounts);
        for (List<String> mergedAccount : mergedAccounts) {
            System.out.println(mergedAccount);
        }

    }

    //disjointSet
    public static List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String , Integer> map = new HashMap<>();

        //connecting the nodes and making the disjoint set and making the ultimate parent
        for(int i=0; i<n; i++){
            for(int j=1; j<acc.get(i).size(); j++){
                String mail = acc.get(i).get(j);

                if(!map.containsKey(mail)){
                    map.put(mail , i);
                }else{
                    ds.unionBySize(i , map.get(mail));
                }
            }
        }

        //merging the mails according to their disjoint set
        List<String>[] merged = new ArrayList[n];
        for(int i=0; i<n; i++)
            merged[i] = new ArrayList<String>();

        for(Map.Entry<String , Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findUparent(it.getValue());
            merged[node].add(mail);
        }

        //rearranging them , I mean the mails
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(merged[i].isEmpty())continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(acc.get(i).get(0));
            for(String it : merged[i])
                temp.add(it);

            ans.add(temp);
        }
        return ans;
    }
}

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUparent(int node){
        if(node == parent.get(node))
            return node;

        parent.set(node , findUparent(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u,int v){
        int ultu = findUparent(u);
        int ultv = findUparent(v);

        if(ultu == ultv)return;

        if(size.get(ultu) < size.get(ultv)){
            parent.set(ultu , ultv);
            size.set(ultv , size.get(ultu) + size.get(ultv));
        }else{
            parent.set(ultv , ultu);
            size.set(ultu , size.get(ultu) + size.get(ultv));
        }
    }
}
