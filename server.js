require('./src/models/User');
const express=require('express')

const app=express();
const mongoose=require('mongoose');
const bodyParser=require('body-parser');
const authRoutes=require('./src/routes/authRoutes');
const requireAuth=require('./src/middlewares/requireAuth');

const mongoUri="mongodb+srv://admin:bhavesh2998@cluster0.cueq3.mongodb.net/workops?retryWrites=true&w=majority";
app.use(bodyParser.json());

app.use(authRoutes);
mongoose.connect(mongoUri,{
    useNewUrlParser:true,
    useCreateIndex:true
});


mongoose.connection.on('connected',()=>{

    console.log("Connected to Mongo");
});
mongoose.connection.on('error',(err)=>{
    console.log("COnnection error");
});
app.get('/',requireAuth,(req,res)=>{
    res.send(`Your Email:${req.user.email}`);
});

app.listen(3000,()=>{
    console.log("app is ready");
});