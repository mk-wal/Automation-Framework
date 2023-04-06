pipeline
{
    agent any
    tools{
    jdk "jdk"
    }

    stages {
       stage('Build') {
         steps {
            echo '>>>Conecting to git repo - MAT >>>>>>>>>>>>>>>'
            //  git 'https://github.com/walacm-sii/Selenium_8.1'
             git branch: "main", url: 'https://github.com/walacm-sii/Selenium_8.1'
             bat 'mvn clean compile'
             //sh 'mvn clean compile' - dla linuxa
             }
        }
         stage('Test') {
           steps {
              echo '>>>Test execution - MAT >>>>>>>>>>>>>>>'

              bat 'mvn clean test'
              //sh 'mvn clean compile' - dla linuxa
            }
        }
    }
}