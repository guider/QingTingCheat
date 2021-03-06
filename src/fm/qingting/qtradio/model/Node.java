package fm.qingting.qtradio.model;

import java.util.Map;

public class Node
  implements InfoManager.INodeEventListener
{
  public transient Node child = null;
  public transient Node nextSibling = null;
  public String nodeName = "node";
  public transient Node parent = null;
  public transient Node prevSibling = null;

  public Node getChild()
  {
    return this.child;
  }

  public Node getNextSibling()
  {
    return this.nextSibling;
  }

  public Node getParent()
  {
    return this.parent;
  }

  public Node getPrevSibling()
  {
    return this.prevSibling;
  }

  public boolean insertChildAtEnd(Node paramNode)
  {
    if (paramNode == null)
      return false;
    paramNode.parent = this;
    if (this.child != null)
      this.child.insertSiblingAtEnd(paramNode);
    while (true)
    {
      return true;
      this.child = paramNode;
    }
  }

  public boolean insertNodeAtEndByParentName(Node paramNode, String paramString)
  {
    boolean bool = true;
    if ((paramNode == null) || (paramString == null))
    {
      bool = false;
      return bool;
    }
    if (this.nodeName.equalsIgnoreCase(paramString))
      return insertChildAtEnd(paramNode);
    for (Node localNode1 = this.nextSibling; ; localNode1 = localNode1.nextSibling)
    {
      if (localNode1 == null)
        break label62;
      if (localNode1.insertNodeAtEndByParentName(paramNode, paramString))
        break;
    }
    label62: for (Node localNode2 = this.child; ; localNode2 = localNode2.child)
    {
      if (localNode2 == null)
        break label93;
      if (localNode2.insertNodeAtEndByParentName(paramNode, paramString))
        break;
    }
    label93: return false;
  }

  public boolean insertSiblingAtEnd(Node paramNode)
  {
    if ((paramNode == null) || (this == null))
      return false;
    while (this.nextSibling != null)
      this = this.nextSibling;
    paramNode.prevSibling = this;
    paramNode.parent = this.parent;
    this.nextSibling = paramNode;
    return true;
  }

  public void onNodeUpdated(Object paramObject, String paramString)
  {
  }

  public void onNodeUpdated(Object paramObject, Map<String, String> paramMap, String paramString)
  {
  }

  public boolean restoreChildFromDB()
  {
    return false;
  }

  public boolean saveChildToDB()
  {
    return false;
  }

  public void setParent(Node paramNode)
  {
    this.parent = paramNode;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.model.Node
 * JD-Core Version:    0.6.2
 */