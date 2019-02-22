package com.nowinski.kamil.befit.tasks;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nowinski.kamil.befit.R;
import com.nowinski.kamil.befit.com.nowinski.kamil.befit.model.Exercise;
import com.nowinski.kamil.befit.com.nowinski.kamil.befit.model.Training;
import com.nowinski.kamil.befit.utils.FileOperations;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializeExerciseListTask extends AsyncTask<Integer, Integer, List<Training>> {
    private final String path = Environment.getExternalStorageDirectory().toString()+"/BeFitFiles";
    private List<Training> trainingList;
    private List<Exercise> chestExercises, shouldersExercises, backExercises, bicepsTricepsExercises,
            stomacheExercises, legsExercises;

    @Override
    protected List<Training> doInBackground(Integer... params) {

        File lastFileBeginner = new File(path + "/progressBeg.txt");
        if(!lastFileBeginner.exists()) {
            chestExercises = new ArrayList<>();
            shouldersExercises = new ArrayList<>();
            backExercises = new ArrayList<>();
            bicepsTricepsExercises = new ArrayList<>();
            stomacheExercises = new ArrayList<>();
            legsExercises = new ArrayList<>();

            List<Integer> seriesRepsA = new ArrayList<>();
            seriesRepsA.add(10);
            seriesRepsA.add(10);
            seriesRepsA.add(12);
            seriesRepsA.add(12);

            chestExercises.add(new Exercise(1,
                    "Wyciskanie sztangi na ławce poziomej", "aaa", seriesRepsA,
                    R.drawable.wyciskanie, R.drawable.wyciskanie_anim, false));
            chestExercises.add(new Exercise(2,
                    "Rozpiętki na ławce ukośnej", "bbb", seriesRepsA,
                    R.drawable.rozpietki, R.drawable.rozpietki_anim, false));
            chestExercises.add(new Exercise(3, "Wyciskanie sztangielek na ławce ukośnej",
                    "ccc", seriesRepsA, R.drawable.wyciskanie_skos, R.drawable.wyciskanie_skos_anim, false));
            chestExercises.add(new Exercise(4, "Wyciskanie sztangielek na ławce poziomej",
                    "ddd", seriesRepsA, R.drawable.wyciskanie_sz, R.drawable.wyciskanie_sz_anim, false));
            chestExercises.add(new Exercise(5, "Wyciskanie sztangi na ławce ukośnej głową w dół",
                    "eee", seriesRepsA, R.drawable.wyciskanie_skos_dol, R.drawable.wyciskanie_skos_dol_anim, false));
            chestExercises.add(new Exercise(6, "Wyciskanie sztangi wąskim chwytem",
                    "fff", seriesRepsA, R.drawable.wyciskanie_waskim, R.drawable.wyciskanie_waskim_anim, false));

            shouldersExercises.add(new Exercise(1, "Wyciskanie żołnierskie",
                    "aaa", seriesRepsA, R.drawable.wyciskanie_zolnierskie, R.drawable.wyciskanie_zolnierskie_anim, false));
            shouldersExercises.add(new Exercise(2, "Wyciskanie sztangielek",
                    "bbb", seriesRepsA, R.drawable.wyciskanie_sztangielek, R.drawable.wyciskanie_sztangielek_anim, false));
            shouldersExercises.add(new Exercise(3, "Unoszenie sztangielek bokiem",
                    "ccc", seriesRepsA, R.drawable.unoszenie_sz_bokiem, R.drawable.unoszenie_sz_bokiem_anim, false));
            shouldersExercises.add(new Exercise(4, "Unoszenie sztangielek bokiem w opadzie tułowia",
                    "ddd", seriesRepsA, R.drawable.unoszenie_sz_opad, R.drawable.unoszenie_sz_opad_anim, false));
            shouldersExercises.add(new Exercise(5, "Podciąganie sztangi wzdłuż tułowia",
                    "eee", seriesRepsA, R.drawable.podciaganie_sztangi, R.drawable.podciaganie_sztangi_anim, false));
            shouldersExercises.add(new Exercise(6, "Odwrotne rozpiętki na maszynie",
                    "fff", seriesRepsA, R.drawable.odwrotne_rozpietki, R.drawable.odwrotne_rozpietki_anim, false));

            backExercises.add(new Exercise(1, "Podciąganie na drążku nachwytem", "aaa",
                    seriesRepsA, R.drawable.podciaganie, R.drawable.podciaganie_anim, false));
            backExercises.add(new Exercise(2, "Wiosłowanie sztangielką na ławce poziomej", "bbb",
                    seriesRepsA, R.drawable.wioslowanie_sztangielka, R.drawable.wioslowanie_sztangielka_anim, false));
            backExercises.add(new Exercise(3, "Ściąganie drążka nachwytem", "ccc",
                    seriesRepsA, R.drawable.sciaganie_drazka, R.drawable.sciaganie_drazka_anim, false));
            backExercises.add(new Exercise(4, "Przyciąganie wyciągu dolnego", "ddd",
                    seriesRepsA, R.drawable.przyciaganie_dol, R.drawable.przyciaganie_dol_anim, false));
            backExercises.add(new Exercise(5, "Skłony ze sztangą", "eee",
                    seriesRepsA, R.drawable.sklony, R.drawable.sklony_anim, false));
            backExercises.add(new Exercise(6, "Martwy ciąg", "fff",
                    seriesRepsA, R.drawable.martwy_ciag, R.drawable.martwy_ciag_anim, false));

            bicepsTricepsExercises.add(new Exercise(1, "Wyciskanie sztangi", "aaa",
                    seriesRepsA, R.drawable.wyciskanie_sztangi, R.drawable.wyciskanie_sztangi_anim, false));
            bicepsTricepsExercises.add(new Exercise(2, "Wyciskanie sztangielek", "bbb",
                    seriesRepsA, R.drawable.wyciskanie_sztangielek, R.drawable.wyciskanie_sztangielek_anim, false));
            bicepsTricepsExercises.add(new Exercise(3, "Wyciskanie sztangi na modlitewniku", "ccc",
                    seriesRepsA, R.drawable.modlitewnik, R.drawable.modlitewnik_anim, false));
            bicepsTricepsExercises.add(new Exercise(4, "Wyciskanie francuskie w siadzie", "ccc",
                    seriesRepsA, R.drawable.wyciskanie_francuskie_siad, R.drawable.wyciskanie_francuskie_siad_anim, false));
            bicepsTricepsExercises.add(new Exercise(5, "Dipy", "eee",
                    seriesRepsA, R.drawable.dipy, R.drawable.dipy_anim, false));
            bicepsTricepsExercises.add(new Exercise(6, "Uginanie sztangi podchwytem", "fff",
                    seriesRepsA, R.drawable.uginanie_podchwyt, R.drawable.uginanie_podchwyt_anim, false));

            stomacheExercises.add(new Exercise(1, "Skłony na ławce poziomej", "aaa",
                    seriesRepsA, R.drawable.sklony_brzuch, R.drawable.sklony_brzuch_anim, false));
            stomacheExercises.add(new Exercise(2, "Unoszenie nóg na drążku", "bbb",
                    seriesRepsA, R.drawable.unoszenie_nog, R.drawable.unoszenie_nog_anim, false));
            stomacheExercises.add(new Exercise(3, "Unoszenie nóg w podporze", "ccc",
                    seriesRepsA, R.drawable.unoszenie_nog_podpora, R.drawable.unoszenie_nog_podpora_anim, false));

            legsExercises.add(new Exercise(1, "Prostowanie nóg w siadzie", "aaa",
                    seriesRepsA, R.drawable.prostowanie_nog, R.drawable.prostowanie_nog_anim, false));
            legsExercises.add(new Exercise(2, "Przysiady ze sztangą na karku", "bbb",
                    seriesRepsA, R.drawable.przysiady_sztanga, R.drawable.przysiady_sztanga_anim, false));
            legsExercises.add(new Exercise(3, "Uginanie nóg na ławce", "ccc",
                    seriesRepsA, R.drawable.uginanie_nog, R.drawable.uginanie_nog_anim, false));
            legsExercises.add(new Exercise(4, "Wspięcia na palcach stojąc", "ddd",
                    seriesRepsA, R.drawable.wspiecia_na_palce, R.drawable.wspiecia_na_palce_anim, false));
            legsExercises.add(new Exercise(5, "Wspiecia na palcach w siadzie", "eee",
                    seriesRepsA, R.drawable.wspiecia_siad, R.drawable.wspiecia_siad_anim, false));
            legsExercises.add(new Exercise(6, "Wypychanie nóg na maszynie", "fff",
                    seriesRepsA, R.drawable.wypychanie_nog, R.drawable.wypychanie_nog_anim, false));

            int choice = params[0];
            if(choice == 1)
                initBeginnerList();
            else if(choice == 2)
                initMediumAdvanceList();
            else if(choice == 3)
                initAdvanceList();
        } else {
            String json = FileOperations.readFromFile(path + "/progressBeg.txt", null);
            Type listType = new TypeToken<ArrayList<Training>>(){}.getType();
            trainingList = new Gson().fromJson(json, listType);
        }
        return trainingList;
    }

    @Override
    protected void onPostExecute(List<Training> result){
        Log.d("exerciseList", "initialize success!");
    }

    private void initBeginnerList(){
        trainingList = new ArrayList<>();
        List<Exercise> day1 = new ArrayList<>();
        List<Exercise> day2 = new ArrayList<>();
        List<Exercise> day3 = new ArrayList<>();
        List<Exercise> day4 = new ArrayList<>();
        List<Exercise> day5 = new ArrayList<>();
        List<Exercise> freeDay = new ArrayList<>();

        for(Exercise e : backExercises)
            day1.add(e);
        for(Exercise e : chestExercises)
            day1.add(e);
        for(Exercise e : shouldersExercises)
            day1.add(e);

        for(Exercise e : bicepsTricepsExercises)
            day2.add(e);
        for(Exercise e : stomacheExercises)
            day2.add(e);
        for(Exercise e : legsExercises)
            day2.add(e);

        for(Exercise e : chestExercises)
            day3.add(e);
        for(Exercise e : shouldersExercises)
            day3.add(e);
        for(Exercise e : backExercises)
            day3.add(e);
        for(Exercise e : bicepsTricepsExercises)
            day3.add(e);
        for(Exercise e : stomacheExercises)
            day3.add(e);
        for(Exercise e : legsExercises)
            day3.add(e);

        for(Exercise e : backExercises)
            day4.add(e);
        for(Exercise e : chestExercises)
            day4.add(e);
        for(Exercise e : shouldersExercises)
            day4.add(e);

        for(Exercise e : bicepsTricepsExercises)
            day5.add(e);
        for(Exercise e : stomacheExercises)
            day5.add(e);
        for(Exercise e : legsExercises)
            day5.add(e);

        int day = 1;
        for(int i = 0; i<4; i++){
            trainingList.add(new Training(day, day1.size(), day1, 0, false));
            day++;
            trainingList.add(new Training(day, day2.size(), day2, 0, false));
            day++;
            trainingList.add(new Training(day, day3.size(), day3, 0, false));
            day++;
            trainingList.add(new Training(day, day4.size(), day4, 0, false));
            day++;
            trainingList.add(new Training(day, day5.size(), day5, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
        }
        trainingList.add(new Training(29, day1.size(), day1, 0, false));
        trainingList.add(new Training(30, day2.size(), day2, 0, false));
        saveFile("progressBeg");
    }

    private void initMediumAdvanceList(){
        trainingList = new ArrayList<>();
        List<Exercise> day1 = new ArrayList<>();
        List<Exercise> day2 = new ArrayList<>();
        List<Exercise> day3 = new ArrayList<>();
        List<Exercise> freeDay = new ArrayList<>();

        for(Exercise e : backExercises)
            day1.add(e);
        for(Exercise e : chestExercises)
            day1.add(e);
        for(Exercise e : shouldersExercises)
            day1.add(e);

        for(Exercise e : bicepsTricepsExercises)
            day2.add(e);
        for(Exercise e : stomacheExercises)
            day2.add(e);
        for(Exercise e : legsExercises)
            day2.add(e);

        for(Exercise e : chestExercises)
            day3.add(e);
        for(Exercise e : shouldersExercises)
            day3.add(e);
        for(Exercise e : backExercises)
            day3.add(e);

        int day = 1;
        for(int i = 0; i<4; i++){
            trainingList.add(new Training(day, day1.size(), day1, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
            trainingList.add(new Training(day, day2.size(), day2, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
            trainingList.add(new Training(day, day3.size(), day3, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
        }
        trainingList.add(new Training(29, day1.size(), day1, 0, false));
        trainingList.add(new Training(30, freeDay.size(), freeDay, 0, false));
        saveFile("progressMed");
    }

    private void initAdvanceList(){
        trainingList = new ArrayList<>();
        List<Exercise> day1 = new ArrayList<>();
        List<Exercise> day2 = new ArrayList<>();
        List<Exercise> day3 = new ArrayList<>();
        List<Exercise> day4 = new ArrayList<>();
        List<Exercise> day5 = new ArrayList<>();
        List<Exercise> freeDay = new ArrayList<>();

        for(Exercise e : backExercises)
            day1.add(e);
        for(Exercise e : chestExercises)
            day1.add(e);
        for(Exercise e : shouldersExercises)
            day1.add(e);

        for(Exercise e : bicepsTricepsExercises)
            day2.add(e);
        for(Exercise e : stomacheExercises)
            day2.add(e);
        for(Exercise e : legsExercises)
            day2.add(e);

        for(Exercise e : chestExercises)
            day3.add(e);
        for(Exercise e : shouldersExercises)
            day3.add(e);
        for(Exercise e : backExercises)
            day3.add(e);
        for(Exercise e : bicepsTricepsExercises)
            day3.add(e);
        for(Exercise e : stomacheExercises)
            day3.add(e);
        for(Exercise e : legsExercises)
            day3.add(e);

        for(Exercise e : backExercises)
            day4.add(e);
        for(Exercise e : chestExercises)
            day4.add(e);
        for(Exercise e : shouldersExercises)
            day4.add(e);

        for(Exercise e : bicepsTricepsExercises)
            day5.add(e);
        for(Exercise e : stomacheExercises)
            day5.add(e);
        for(Exercise e : legsExercises)
            day5.add(e);

        int day = 1;
        for(int i = 0; i<4; i++){
            trainingList.add(new Training(day, day1.size(), day1, 0, false));
            day++;
            trainingList.add(new Training(day, day2.size(), day2, 0, false));
            day++;
            trainingList.add(new Training(day, day3.size(), day3, 0, false));
            day++;
            trainingList.add(new Training(day, day4.size(), day4, 0, false));
            day++;
            trainingList.add(new Training(day, day5.size(), day5, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
            trainingList.add(new Training(day, freeDay.size(), freeDay, 0, false));
            day++;
        }
        trainingList.add(new Training(29, day1.size(), day1, 0, false));
        trainingList.add(new Training(30, day2.size(), day2, 0, false));
        saveFile("progressAdv");
    }

    private void saveFile(String fileName){
        File dir = new File(path);
        if(!dir.exists())
            FileOperations.createDir(path);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(trainingList);
        FileOperations.createFile(path,fileName, json);
    }
}