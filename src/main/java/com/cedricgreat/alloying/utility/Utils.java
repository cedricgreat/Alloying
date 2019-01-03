package com.cedricgreat.alloying.utility;

import com.cedricgreat.alloying.reference.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils
{
    private static Logger Logger;

    public static Logger getLogger()
    {
        if(Logger == null)
        {
            Logger = LogManager.getFormatterLogger(Reference.MOD_ID);
        }
        return Logger;
    }
}
