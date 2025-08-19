pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'cadastro-clientes'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build com Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Verificar acesso ao Docker') {
            steps {
                sh 'docker version'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
            }
        }

        stage('Deploy com Docker Compose') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose up -d --build'
            }
        }

        stage('Verificação') {
            steps {
                echo '✅ Jenkins está lendo o Jenkinsfile corretamente!'
            }
        }
    }

    post {
        success {
            echo '✅ Deploy do cadastro-cliente concluído com sucesso!'
        }
        failure {
            echo '❌ Falha no pipeline. Verifique os logs.'
        }
    }
}