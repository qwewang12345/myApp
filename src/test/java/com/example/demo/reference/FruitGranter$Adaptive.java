package com.example.demo.reference;
import com.example.demo.service.spi.adaptive.FruitGranter;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class FruitGranter$Adaptive implements FruitGranter {

    @Override
    public java.lang.String watering(org.apache.dubbo.common.URL arg0)  {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        org.apache.dubbo.common.URL url = arg0;
        String extName = url.getParameter("fruit.granter");
        if(extName == null) {
            throw new IllegalStateException("Failed to get extension (com.example.demo.service.spi.adaptive.FruitGranter) name from url (" + url.toString() + ") use keys([fruit.granter])");
        }
        FruitGranter extension = ExtensionLoader.getExtensionLoader(FruitGranter.class).getExtension(extName);
        return extension.watering(arg0);
    }

    @Override
    public void grant()  {
        throw new UnsupportedOperationException("The method public abstract void com.example.demo.service.spi.adaptive.FruitGranter.grant() of interface com.example.demo.service.spi.adaptive.FruitGranter is not adaptive method!");
    }
}