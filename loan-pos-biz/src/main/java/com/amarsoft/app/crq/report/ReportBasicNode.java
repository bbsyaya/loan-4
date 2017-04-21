package com.amarsoft.app.crq.report;

import com.amarsoft.are.jbo.BizObject;
import com.amarsoft.are.jbo.BizObjectClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class ReportBasicNode
{
  protected String id;
  protected String name;
  protected String label;
  protected String jboClass;
  protected BizObjectClass bizObjectClass;
  protected List<BizObject> content;
  protected Properties properties;
  protected boolean multi;

  public String getId()
  {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLabel() {
    return this.label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public String getJboClass() {
    return this.jboClass;
  }
  public void setJboClass(String jboClass) {
    this.jboClass = jboClass;
  }
  public List<BizObject> getContent() {
    return this.content;
  }
  public Properties getProperties() {
    return this.properties;
  }
  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public void addContent(BizObject bo) {
    if (bo == null) return;
    if (getContent() == null) setContent(new ArrayList());
    getContent().add(bo);
  }

  public void setContent(List<BizObject> content) {
    this.content = content;
  }

  public BizObjectClass getBizObjectClass() {
    return this.bizObjectClass;
  }
  public void setBizObjectClass(BizObjectClass bizObjectClass) {
    this.bizObjectClass = bizObjectClass;
  }

  public String toString()
  {
    return getId() + "-" + getName() + "-" + getLabel();
  }
  
	public boolean isMulti() {
		return multi;
	}
	public void setMulti(boolean multi) {
		this.multi = multi;
	}
  
  
}