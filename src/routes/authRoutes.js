const express = require('express');
const router = express.Router();

//To access User Model:- 
const mongoose=require('mongoose');
const User=mongoose.model('User');

const jwt=require('jsonwebtoken');

const app=express();

router.post('/signup',async (req,res)=>{
    const {email,password} = req.body;
    try{
        const user=new User({email,password});
        await user.save();
        const token=jwt.sign({userId:user._id},"MY_SECRET_KEY");
        res.send({token});
    }
    catch(e){
        res.status(422).send("Something Went Wrong!");
    }
});

router.post("/signin",async (req,res)=>{
    const {email,password} = req.body;
    if(!email || !password){
        return res.status(422).send("Email Or Password Must Not Be Empty");
    }
    const user =await User.findOne({email});
    if(!user){
        return res.status(422).send({error:"User Not Found"});
    }
    try{
        await user.comparePassword(password);
        const token = jwt.sign({userId:user._id},"MY_SECRET_KEY");
        res.send("SuccessFully Logged In!");
    }
    catch(e){
        res.status(422).send({error:"Invalid Email or Password."});
    }
})

module.exports=router;