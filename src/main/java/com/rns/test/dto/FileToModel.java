package com.rns.test.dto;

import com.rns.test.models.TireModel;

import java.io.File;
import java.util.List;

public interface FileToModel {

     List<TireModel> mapFile(File file) throws Exception;
}
