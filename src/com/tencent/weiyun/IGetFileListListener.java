package com.tencent.weiyun;

import com.tencent.tauth.UiError;
import java.util.List;

public abstract interface IGetFileListListener
{
  public abstract void onComplete(List<WeiyunFile> paramList);

  public abstract void onError(UiError paramUiError);
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.IGetFileListListener
 * JD-Core Version:    0.6.2
 */