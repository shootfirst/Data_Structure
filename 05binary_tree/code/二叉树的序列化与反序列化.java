public class Codec {
    public String serialize(TreeNode root) {
        return rserialize(root, );
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(,);
        ListString dataList = new LinkedList(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += None,;
        } else {
            str += str.valueOf(root.val) + ,;
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(ListString dataList) {
        if (dataList.get(0).equals(None)) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
