package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;



public class PublisherConverter implements Converter<String, Publisher> {
   @Autowired
private PublisherDao pd;


   @Override
    public Publisher convert(String pubId) {
        return pd.findById(Long.parseLong(pubId));
    }
}
