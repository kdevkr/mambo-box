## Aurora PostgreSQL IAM Authentication

The Amazon Web Services (AWS) JDBC Driver supports [IAM database authentication](https://github.com/aws/aws-advanced-jdbc-wrapper/blob/main/docs/using-the-jdbc-driver/using-plugins/UsingTheIamAuthenticationPlugin.md).

- [Aurora PostgreSQL 11+](https://docs.aws.amazon.com/ko_kr/AmazonRDS/latest/AuroraUserGuide/Concepts.Aurora_Fea_Regions_DB-eng.Feature.IAMdbauth.html#Concepts.Aurora_Fea_Regions_DB-eng.Feature.IAMdbauth.apg)
- [RDS for PostgreSQL 10+](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.RDS_Fea_Regions_DB-eng.Feature.IamDatabaseAuthentication.html#Concepts.RDS_Fea_Regions_DB-eng.Feature.IamDatabaseAuthentication.pg)

### IAM policy for IAM database access

IAM 데이터베이스 인증을 위한 `rds-db:connect` 권한 정책 부여

```json
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
             "rds-db:connect"
         ],
         "Resource": [
             "arn:aws:rds-db:ap-northeast-2:[account-id]:dbuser:[DbiResourceId or DbClusterResourceId]/[db-username]"
         ]
      }
   ]
}
```

- [IAM database authentication](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/UsingWithRDS.IAMDBAuth.html)
- [Creating and using an IAM policy for IAM database access](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.IAMDBAuth.IAMPolicy.html)

### GRANT rds_iam role

PostgreSQL 에서 IAM 인증을 위해서는 데이터베이스 사용자가 rds_iam 역할을 가져야 IAM 자격증명 기반으로 PAM Authentication 이 가능.

```sh
GRANT rds_iam TO db_username;
```

### Try connect using CLI

[ap-northeast-2-bundle.pem](https://truststore.pki.rds.amazonaws.com/ap-northeast-2/ap-northeast-2-bundle.pem) CA 다운로드

```sh
RDSHOST="[cluster-endpoint]"
PGPASSWORD=$(aws rds generate-db-auth-token --hostname $RDSHOST --port 5432 --region ap-northeast-2 --username [db-username] --profile [iam-role-profile])
psql "host=$RDSHOST port=5432 sslmode=verify-full sslrootcert=ap-northeast-2-bundle.pem dbname=[database] user=[db-username] password=$PGPASSWORD" -c "select version()"
```

- [Connecting to a PostgreSQL DB instance over SSL](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/PostgreSQL.Concepts.General.SSL.html)
- [Download certificate bundles for Amazon RDS](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.SSL.html#UsingWithRDS.SSL.CertificatesDownload)
