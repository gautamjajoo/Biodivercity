package com.example.sridhar123.biodiversity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateNewPost extends BioBaseActivity {

    @BindView(R.id.button_upload)
    Button btnUpload;
    @BindView(R.id.image_bio)
    ImageView imageView;
    @BindView(R.id.current_location)
    TextInputEditText currentLocation;
    @BindView(R.id.description)
    TextInputEditText description;
    @BindView(R.id.species)
    TextInputEditText species;
    Uri imageUri;
    static ArrayList<NewPost> newPost;

    static {
        newPost = new ArrayList<>();
    }

    private int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_upload)
    public void buttonUpload() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            try{
                imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(CreateNewPost.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    }

    @OnClick(R.id.button_save)
    public void buttonSaveAction() {

        String currentLocation1 = currentLocation.getText().toString();
        String description1 = description.getText().toString();
        String species1 = species.getText().toString();

        if(currentLocation1.isEmpty())
            Toast.makeText(this, "Enter Location!", Toast.LENGTH_SHORT).show();
        else if(description1.isEmpty())
            Toast.makeText(this, "Enter Description!", Toast.LENGTH_SHORT).show();
        else if(species1.isEmpty())
            Toast.makeText(this, "Enter Species!", Toast.LENGTH_SHORT).show();
        else if(imageUri == null)
            Toast.makeText(this, "Upload Image!", Toast.LENGTH_SHORT).show();
        else {
            newPost.add(new NewPost(imageUri.toString(), currentLocation1, description1, species1));
            Intent intent = new Intent(CreateNewPost.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", newPost);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
