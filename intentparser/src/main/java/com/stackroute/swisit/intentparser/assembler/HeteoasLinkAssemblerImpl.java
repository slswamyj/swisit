package com.stackroute.swisit.intentparser.assembler;
/*-----Importing Liberaries-----*/
import com.stackroute.swisit.intentparser.domain.IntentParserResult;
import java.util.List;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.stereotype.Service;
/*-------Implementation to HateoasLinkAssembler interface------*/
@Service
public class HeteoasLinkAssemblerImpl implements HeteoasLinkAssembler {
/*------Overriding CalculateConfidence method of Interface Class------*/
@Override
    public  List<IntentParserResult> calculateConfidence(List<IntentParserResult> results)
    {
        for(IntentParserResult intentParserResult : results) {
            Link selfLink =linkTo(IntentParserResult.class).slash("intentParserResult.getUrl()").withSelfRel();
            intentParserResult.add(selfLink);
        }
        return results;
    }
}