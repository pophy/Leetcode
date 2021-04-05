
public class SegmentTreeBuild {
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
           return new SegmentTreeNode(start, end);
        } else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            SegmentTreeNode left = build(start, start + (end - start) / 2);
            SegmentTreeNode right = build(1 + start + (end - start) / 2, end);
            node.left = left;
            node.right = right;
            return node;
        }

    }

    public static void main(String[] args) {
        SegmentTreeBuild build = new SegmentTreeBuild();
        build.build(1,4);
    }
}


  class SegmentTreeNode {
         public int start, end;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end) {
                 this.start = start;
                 this.end = end;
                 this.left = this.right = null;
             }
     }
