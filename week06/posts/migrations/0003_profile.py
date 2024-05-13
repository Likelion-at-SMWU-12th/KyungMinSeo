# Generated by Django 5.0.5 on 2024-05-13 14:14

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('posts', '0002_alter_post_view_count'),
    ]

    operations = [
        migrations.CreateModel(
            name='Profile',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('profile_img', models.ImageField(upload_to='', verbose_name='프로필사진')),
                ('profile_name', models.TextField(verbose_name='닉네임')),
                ('birthday', models.DateField(verbose_name='생년월일')),
                ('profile_comment', models.TextField(verbose_name='한줄소개')),
            ],
        ),
    ]
