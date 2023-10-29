pipeline {
    agent any

    stages {
        stage("GIT") {
            steps {
                // Clone the Git repository
                git url: 'https://github.com/ademwertani/5SIM3_G5_projet3.git'
            }
        }

        stage("MVN CLEAN") {
            steps {
                // Run 'mvn clean' in the project directory
                sh 'mvn clean'
            }
        }

        stage("MVN COMPILE") {
            steps {
                // Run 'mvn compile' in the project directory
                sh 'mvn compile'
            }
        }

        stage("build") {
            steps {
                echo 'building the application...'
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
            }
        }

        stage("deploy") {
            steps {
                echo 'deploying the application'
            }
        }
    }
}

