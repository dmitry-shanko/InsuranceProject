package main.java.by.itacademy.resources;

import java.util.Locale;

public interface Localizator 
{
	String getString(String key);
	String getEnum(Enum<? extends Enum<?>> e);
	void setNewBundle(Locale locale);
	void setNewStringResBundle(String baseName, Locale locale);
	void setNewEnumResBundle(String baseName, Locale locale);
	
}
