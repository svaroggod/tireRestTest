package com.rns.test.dto;


import java.io.File;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.rns.test.models.TireModel;
import org.springframework.stereotype.Component;

@Component
public class CSVMappedToModel implements FileToModel{

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<TireModel> mapFile(File file) throws Exception {

        if (file == null) return null;
        CsvToBean csv = new CsvToBean();
        CSVReader csvReader = new CSVReader(new FileReader(file));
        return (List<TireModel>) csv.parse(setColumMapping(), csvReader);

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(TireModel.class);
        String[] columns = new String[]{"brand", "model", "width", "height", "construct", "diameter", "resIndex",
                "speedIndex", "abbs", "runFlat", "camera", "season"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
