package com.teca.test.usecase;

import com.teca.usecase.DownloadDbUseCase;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by truonglx.
 */
public class DownloadUseCaseTest {

    public static void main(String[] args) throws IOException, JSONException {
        DownloadDbUseCase useCase=new DownloadDbUseCase();
        useCase.download();
    }
}
