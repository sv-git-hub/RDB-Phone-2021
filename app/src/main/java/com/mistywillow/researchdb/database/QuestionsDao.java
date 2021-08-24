package com.mistywillow.researchdb.database;

import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.mistywillow.researchdb.database.entities.Questions;

import java.util.List;

@Dao
public interface QuestionsDao {
    @Insert
    long addQuestion(Questions question);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateQuestion(Questions question);

    @Delete
    void deleteQuestion(Questions question);

    @Query("SELECT * FROM Questions ORDER BY Question")
    List<Questions> getQuestions();

    @Query("SELECT * FROM Questions WHERE QuestionID = :questionID")
    Questions getQuestion(int questionID);

    @Query("SELECT QuestionID FROM Questions WHERE Question = :question")
    int getQuestionByValue(String question);

    @Query("SELECT COUNT(*) FROM Questions WHERE question = :question")
    int getCountByValue(String question);

    @Query("SELECT last_insert_rowid()")
    int lastQuestionPKID();

    @RawQuery
    List<Integer> customSearchQuestionsTable(SupportSQLiteQuery query);
}
