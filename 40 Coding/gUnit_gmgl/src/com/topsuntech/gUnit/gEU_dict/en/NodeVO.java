package com.topsuntech.gUnit.gEU_dict.en;

import java.io.Serializable;

public class NodeVO
    implements Serializable
{

    private String code; //±àÂë
    private String name; //Ãû³Æ
    
    public NodeVO(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
    
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        StringBuffer buf = new StringBuffer("\nNodeVO: ");
        buf.append("[code=");
        buf.append(code);
        buf.append("];name=[");
        buf.append(name);
        buf.append("]\n");
        return buf.toString();
    }

}
