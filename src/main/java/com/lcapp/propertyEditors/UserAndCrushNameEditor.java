package com.lcapp.propertyEditors;

import java.beans.PropertyEditorSupport;

public class UserAndCrushNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		text=text.replaceAll("\\s{2,}"," ");
		text=text.trim();
		String[] split = text.split(" ");
		String newString="";
		for(int i=0;i<split.length;i++)
		{
			split[i]=split[i].replaceAll("\\s","");
		String firstLetter=split[i].substring(0,1).toUpperCase();
		split[i]=firstLetter+split[i].substring(1);
		newString=newString+" "+split[i];
		}
		setValue(newString);
	}

}
