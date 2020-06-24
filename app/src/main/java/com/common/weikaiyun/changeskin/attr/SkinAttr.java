package com.common.weikaiyun.changeskin.attr;

import android.view.View;

public class SkinAttr {
    public String resName;
    public SkinAttrType attrType;


    public SkinAttr(SkinAttrType attrType, String resName) {
        this.resName = resName;
        this.attrType = attrType;
    }

    public void apply(View view) {
        attrType.apply(view, resName);
    }
}
