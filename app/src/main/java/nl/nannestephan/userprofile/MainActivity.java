package nl.nannestephan.userprofile;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    //Dialog
    Dialog editProfileDialog;
    TextView DialogHeader;
    TextView DialogTextView;
    String DialogText;

    Button NextButton;

    // ProfilePage
    TextView profileName;
    TextView profileCountry;
    Button saveEdit;

    // Profile
    EditText SubmitProfileName;
    TextView QuestionPage;
    TextView UserNameLine;

    // Numbers Line 123456
    TextView QuestionNumberOne;
    TextView QuestionNumberTwo;
    TextView QuestionNumberThree;
    TextView QuestionNumberFour;
    TextView QuestionNumberFive;
    TextView QuestionNumberSix;

    //RadioGroup Buttons
    RadioGroup AnswerRadioGroupOne;
    RadioGroup AnswerRadioGroupTwo;
    RadioButton AnswerTopLeft;
    RadioButton AnswerTopRight;
    RadioButton AnswerBottomLeft;
    RadioButton AnswerBottomRight;

    //setVisibility
    ImageView BackgroundQuestion;
    LinearLayout CorrectIncorrectView;
    LinearLayout RadioGroupVisibility;
    LinearLayout Buttons;
    Button NameButton;
    LinearLayout EndPage;
    Button submitScore;

    // UserName Line
    TextView UserNameTextView;
    String Hallo;


    // Question 1
    String LineOne;
    String QuestionOne;
    String AnswerOneQuestionOne;
    String AnswerTwoQuestionOne;
    String AnswerThreeQuestionOne;
    String AnswerFourQuestionOne;
    // Question 2
    String LineTwo;
    String QuestionTwo;
    String AnswerOneQuestionTwo;
    String AnswerTwoQuestionTwo;
    String AnswerThreeQuestionTwo;
    String AnswerFourQuestionTwo;
    // Question 3
    String LineThree;
    String QuestionThree;
    String AnswerOneQuestionThree;
    String AnswerTwoQuestionThree;
    String AnswerThreeQuestionThree;
    String AnswerFourQuestionThree;
    // Question 4
    String LineFour;
    String QuestionFour;
    String AnswerOneQuestionFour;
    String AnswerTwoQuestionFour;
    String AnswerThreeQuestionFour;
    String AnswerFourQuestionFour;
    // Question 5
    String LineFive;
    String QuestionFive;
    String AnswerOneQuestionFive;
    String AnswerTwoQuestionFive;
    String AnswerThreeQuestionFive;
    String AnswerFourQuestionFive;
    // Question 6
    String LineSix;
    String QuestionSix;
    String AnswerOneQuestionSix;
    String AnswerTwoQuestionSix;
    String AnswerThreeQuestionSix;
    String AnswerFourQuestionSix;

    //Correct & Incorrect Score;
    TextView CorrectScore;
    TextView IncorrectScore;

    //End Icons
    ImageView endIconQuestionOne;
    ImageView endIconQuestionTwo;
    ImageView endIconQuestionThree;
    ImageView endIconQuestionFour;
    ImageView endIconQuestionFive;
    ImageView endIconQuestionSix;


    // Quiz Place
    int Question;
    int Correct;
    int Incorrect;

    //RadioButton Count
    int RadioOne;
    int RadioTwo;
    int RadioThree;
    int RadioFour;


    String name;

    static final String lastQuestion = "ScoreTeamA";
    static final String LastCorrectCount = "Correct";
    static final String LastInCorrectCount = "Incorrect";

    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt(lastQuestion, Question);
        savedInstanceState.putInt(LastCorrectCount, Correct);
        savedInstanceState.putInt(LastInCorrectCount, Incorrect);

        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * restore the score
     */

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)

            Question = savedInstanceState.getInt(lastQuestion);
        Correct = savedInstanceState.getInt(LastCorrectCount);
        Incorrect = savedInstanceState.getInt(LastInCorrectCount);




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ProfilePage
        QuestionPage = findViewById(R.id.QuestionTextView);
        SubmitProfileName = findViewById(R.id.editProfileName);

        DialogText = getString(R.string.DialogText);


        // Numbers Line 123456
        QuestionNumberOne = findViewById(R.id.One);
        QuestionNumberTwo = findViewById(R.id.Two);
        QuestionNumberThree = findViewById(R.id.Three);
        QuestionNumberFour = findViewById(R.id.Four);
        QuestionNumberFive = findViewById(R.id.Five);
        QuestionNumberSix = findViewById(R.id.Six);

        //RadioGroup Buttons
        AnswerRadioGroupOne = findViewById(R.id.AnswerRadioGroupOne);
        AnswerRadioGroupTwo = findViewById(R.id.AnswerRadioGroupTwo);

        AnswerTopLeft = findViewById(R.id.RadioButtonTopLeft);
        AnswerTopRight = findViewById(R.id.RadioButtonTopRight);
        AnswerBottomLeft = findViewById(R.id.RadioButtonBottomLeft);
        AnswerBottomRight = findViewById(R.id.RadioButtonBottomRight);


        //setVisibility
        CorrectIncorrectView = findViewById(R.id.CorrectIncorrectView);
        BackgroundQuestion = findViewById(R.id.BackgroundQuestion);
        RadioGroupVisibility = findViewById(R.id.RadioGroup);
        NameButton = findViewById(R.id.UserNameButton);
        NextButton = findViewById(R.id.NextButton);
        EndPage = findViewById(R.id.Endpage);
        submitScore = findViewById(R.id.submitScore);

        //Score
        CorrectScore = findViewById(R.id.correctScore);
        IncorrectScore = findViewById(R.id.incorrectScore);

        //UserName Text View
        UserNameTextView = findViewById(R.id.UserNameLine);
        Hallo = getString(R.string.Hallo);
        name = getString(R.string.name);

        // Question 1
        LineOne = getString(R.string.LineOne);
        QuestionOne = getString(R.string.QuestionOne);
        AnswerOneQuestionOne = getString(R.string.AnswerOneQuestionOne);
        AnswerTwoQuestionOne = getString(R.string.AnswerTwoQuestionOne);
        AnswerThreeQuestionOne = getString(R.string.AnswerThreeQuestionOne);
        AnswerFourQuestionOne = getString(R.string.AnswerFourQuestionOne);
        // Question 2
        LineTwo = getString(R.string.LineTwo);
        QuestionTwo = getString(R.string.QuestionTwo);
        AnswerOneQuestionTwo = getString(R.string.AnswerOneQuestionTwo);
        AnswerTwoQuestionTwo = getString(R.string.AnswerTwoQuestionTwo);
        AnswerThreeQuestionTwo = getString(R.string.AnswerThreeQuestionTwo);
        AnswerFourQuestionTwo = getString(R.string.AnswerFourQuestionTwo);
        // Question 3
        LineThree = getString(R.string.LineThree);
        QuestionThree = getString(R.string.QuestionThree);
        AnswerOneQuestionThree = getString(R.string.AnswerOneQuestionThree);
        AnswerTwoQuestionThree = getString(R.string.AnswerTwoQuestionThree);
        AnswerThreeQuestionThree = getString(R.string.AnswerThreeQuestionThree);
        AnswerFourQuestionThree = getString(R.string.AnswerFourQuestionThree);
        // Question 4
        LineFour = getString(R.string.LineFour);
        QuestionFour = getString(R.string.QuestionFour);
        AnswerOneQuestionFour = getString(R.string.AnswerOneQuestionFour);
        AnswerTwoQuestionFour = getString(R.string.AnswerTwoQuestionFour);
        AnswerThreeQuestionFour = getString(R.string.AnswerThreeQuestionFour);
        AnswerFourQuestionFour = getString(R.string.AnswerFourQuestionFour);
        // Question 5
        LineFive = getString(R.string.LineFive);
        QuestionFive = getString(R.string.QuestionFive);
        AnswerOneQuestionFive = getString(R.string.AnswerOneQuestionFive);
        AnswerTwoQuestionFive = getString(R.string.AnswerTwoQuestionFive);
        AnswerThreeQuestionFive = getString(R.string.AnswerThreeQuestionFive);
        AnswerFourQuestionFive = getString(R.string.AnswerFourQuestionFive);
        // Question 6
        LineSix = getString(R.string.LineSix);
        QuestionSix = getString(R.string.QuestionSix);
        AnswerOneQuestionSix = getString(R.string.AnswerOneQuestionSix);
        AnswerTwoQuestionSix = getString(R.string.AnswerTwoQuestionSix);
        AnswerThreeQuestionSix = getString(R.string.AnswerThreeQuestionSix);
        AnswerFourQuestionSix = getString(R.string.AnswerFourQuestionSix);
        //End Icons ImageView
        endIconQuestionOne = findViewById(R.id.endIconQuestionOne);
        endIconQuestionTwo = findViewById(R.id.endIconQuestionTwo);
        endIconQuestionThree = findViewById(R.id.endIconQuestionThree);
        endIconQuestionFour = findViewById(R.id.endIconQuestionFour);
        endIconQuestionFive = findViewById(R.id.endIconQuestionFive);
        endIconQuestionSix = findViewById(R.id.endIconQuestionSix);
    }

    public void UserNameButton(View view) {
        SubmitProfileName.setVisibility(View.INVISIBLE);
        NameButton.setVisibility(View.INVISIBLE);

        Editable nameEditable = SubmitProfileName.getText();
        name = nameEditable.toString();

        editProfileDialog = new Dialog(this, R.style.NewDialog);
        editProfileDialog.setContentView(R.layout.profile_edit_dialog);

        final TextView Header = editProfileDialog.findViewById(R.id.DialogHeader);
        final TextView Text = editProfileDialog.findViewById(R.id.DialogText);


        saveEdit = editProfileDialog.findViewById(R.id.saveNewProfile);
        DialogHeader = findViewById(R.id.DialogHeader);
        DialogTextView = findViewById(R.id.DialogText);

        saveEdit.setEnabled(true);
        Header.setEnabled(true);
        Text.setEnabled(true);

        Header.setText(Hallo + " " + name);
        Text.setText(DialogText);


        editProfileDialog.show();
    }

    public void saveProfileDialog(View view) {
        QuestionNumberOne.setTextAppearance(R.style.QuestionNumberLarge);

        UserNameTextView.setText(Hallo + " " + name + " " + LineOne);

        QuestionPage.setText(QuestionOne);


        AnswerTopLeft.setText(AnswerOneQuestionOne);
        AnswerTopRight.setText(AnswerTwoQuestionOne);
        AnswerBottomLeft.setText(AnswerThreeQuestionOne);
        AnswerBottomRight.setText(AnswerFourQuestionOne);

        NextButton.setVisibility(View.VISIBLE);
        BackgroundQuestion.setVisibility(View.VISIBLE);
        CorrectIncorrectView.setVisibility(View.VISIBLE);
        RadioGroupVisibility.setVisibility(View.VISIBLE);


        Question++;
        editProfileDialog.cancel();
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Disable RadioButtons
        AnswerTopLeft.setEnabled(false);
        AnswerTopRight.setEnabled(false);
        AnswerBottomLeft.setEnabled(false);
        AnswerBottomRight.setEnabled(false);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioButtonTopLeft:
                if (checked)
                    RadioOne = 1;
                break;
            case R.id.RadioButtonTopRight:
                if (checked)
                    if (Question == 0)
                        RadioTwo = 1;
                break;
            case R.id.RadioButtonBottomLeft:
                if (checked)
                    RadioThree = 1;
                break;
            case R.id.RadioButtonBottomRight:
                if (checked)
                    RadioFour = 1;
                break;

        }

    }


    public void NextButton(View v) {
        AnswerRadioGroupOne.clearCheck();
        AnswerRadioGroupTwo.clearCheck();

        AnswerTopLeft.setEnabled(true);
        AnswerTopRight.setEnabled(true);
        AnswerBottomLeft.setEnabled(true);
        AnswerBottomRight.setEnabled(true);


        //Question One
        if (Question == 0) {

            if (RadioTwo == 1) {
                Correct++;
                RadioTwo--;
                displayCorrectScore(Correct);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
                endIconQuestionOne.setImageResource(R.drawable.correct_icon);
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionOne.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }

        //Question Two
        if (Question == 1) {
            QuestionNumberOne.setTextAppearance(R.style.QuestionNumberSmall);
            QuestionNumberTwo.setTextAppearance(R.style.QuestionNumberLarge);

            UserNameTextView.setText(LineTwo);
            QuestionPage.setText(QuestionTwo);

            AnswerTopLeft.setText(AnswerOneQuestionTwo);
            AnswerTopRight.setText(AnswerThreeQuestionTwo);
            AnswerBottomLeft.setText(AnswerThreeQuestionTwo);
            AnswerBottomRight.setText(AnswerFourQuestionTwo);

            if (RadioThree == 1) {
                Correct++;
                RadioThree--;
                displayCorrectScore(Correct);
                endIconQuestionOne.setImageResource(R.drawable.correct_icon);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionOne.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }
        //Question Three
        if (Question == 2) {
            QuestionNumberTwo.setTextAppearance(R.style.QuestionNumberSmall);
            QuestionNumberThree.setTextAppearance(R.style.QuestionNumberLarge);

            UserNameTextView.setText(LineThree);
            QuestionPage.setText(QuestionThree);

            AnswerTopLeft.setText(AnswerOneQuestionThree);
            AnswerTopRight.setText(AnswerTwoQuestionThree);
            AnswerBottomLeft.setText(AnswerThreeQuestionThree);
            AnswerBottomRight.setText(AnswerFourQuestionThree);

            if (RadioFour == 1) {
                Correct++;
                RadioFour--;
                displayCorrectScore(Correct);
                endIconQuestionThree.setImageResource(R.drawable.correct_icon);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionThree.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }
        //Question Four
        if (Question == 3) {
            QuestionNumberThree.setTextAppearance(R.style.QuestionNumberSmall);
            QuestionNumberFour.setTextAppearance(R.style.QuestionNumberLarge);

            UserNameTextView.setText(LineFour);
            QuestionPage.setText(QuestionFour);

            AnswerTopLeft.setText(AnswerOneQuestionFour);
            AnswerTopRight.setText(AnswerTwoQuestionFour);
            AnswerBottomLeft.setText(AnswerThreeQuestionFour);
            AnswerBottomRight.setText(AnswerFourQuestionFour);

            if (RadioOne == 5) {
                Correct++;
                RadioOne--;
                displayCorrectScore(Correct);
                endIconQuestionFour.setImageResource(R.drawable.correct_icon);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionFour.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }
        //Question Five
        if (Question == 4) {
            QuestionNumberFour.setTextAppearance(R.style.QuestionNumberSmall);
            QuestionNumberFive.setTextAppearance(R.style.QuestionNumberLarge);

            UserNameTextView.setText(LineFive);
            QuestionPage.setText(QuestionFive);

            AnswerTopLeft.setText(AnswerOneQuestionFive);
            AnswerTopRight.setText(AnswerThreeQuestionFive);
            AnswerBottomLeft.setText(AnswerThreeQuestionFive);
            AnswerBottomRight.setText(AnswerFourQuestionFive);

            if (RadioFour == 1) {
                Correct++;
                RadioFour--;
                displayCorrectScore(Correct);
                endIconQuestionFive.setImageResource(R.drawable.correct_icon);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionFive.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }
        //Question Six
        if (Question == 5) {
            QuestionNumberFive.setTextAppearance(R.style.QuestionNumberSmall);
            QuestionNumberSix.setTextAppearance(R.style.QuestionNumberLarge);

            UserNameTextView.setText(LineSix);
            QuestionPage.setText(QuestionSix);

            AnswerTopLeft.setText(AnswerOneQuestionSix);
            AnswerTopRight.setText(AnswerTwoQuestionSix);
            AnswerBottomLeft.setText(AnswerThreeQuestionSix);
            AnswerBottomRight.setText(AnswerFourQuestionSix);

            if (RadioOne == 1) {
                Correct++;
                RadioOne--;
                displayCorrectScore(Correct);
                endIconQuestionSix.setImageResource(R.drawable.correct_icon);
                Toast.makeText(this, "That is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "That is Incorrect", Toast.LENGTH_SHORT).show();
                Incorrect++;
                endIconQuestionSix.setImageResource(R.drawable.incorrect_icon);
                displayIncorrectScore(Incorrect);
            }

            Question++;
            return;
        }
        //End Dialog
        if (Question == 6) {

            NextButton.setVisibility(View.INVISIBLE);
            BackgroundQuestion.setVisibility(View.INVISIBLE);
            CorrectIncorrectView.setVisibility(View.INVISIBLE);
            RadioGroupVisibility.setVisibility(View.INVISIBLE);
            UserNameTextView.setVisibility(View.INVISIBLE);
            QuestionPage.setVisibility(View.INVISIBLE);

            EndPage.setVisibility(View.VISIBLE);
            submitScore.setVisibility(View.VISIBLE);


        }


    }

    public void submitScore(View view) {
        String message = createScoreSummary(name);
        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        editProfileDialog.cancel();
    }

    public String createScoreSummary(String name) {

        String EndDialog = getString(R.string.summary_name, name);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionOne) + "" + (endIconQuestionOne);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionTwo) + "" + (endIconQuestionTwo);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionThree) + "" + (endIconQuestionThree);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionFour) + "" + (endIconQuestionFour);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionFive) + "" + (endIconQuestionFive);
        EndDialog += "\n" + getString(R.string.Dialog_QuestionSix) + "" + (endIconQuestionSix);
        EndDialog += "\n" + getString(R.string.summary_correct) + "" + (Correct);
        EndDialog += "\n" + getString(R.string.summary_incorrect) + "" + (Incorrect);
        EndDialog += "\n" + getString(R.string.thank_you);
        return EndDialog;
    }

    public void displayCorrectScore(int Correct) {
        TextView CorrectScore = findViewById(R.id.correctScore);
        CorrectScore.setText("" + Correct);


    }

    public void displayIncorrectScore(int Incorrect) {
        TextView IncorrectScore = findViewById(R.id.incorrectScore);
        IncorrectScore.setText("" + Incorrect);
    }


}



