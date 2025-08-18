pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-17'
            args '-v /root/.m2:/root/.m2' // opcional: cache do Maven
        }
    }

    environment {
        DOCKER_IMAGE = 'cadastro-cliente'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/lleolopes03/cadastro-cliente.git'
            }
        }

        stage('Build com Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
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