import Test.Hspec
import Control.Monad.Reader
import Calibration hiding(main)


withInput :: (Reader () String -> Reader () Int) ->String -> Int
f `withInput` s = runReader (f (reader (\_ -> s))) ()

main = hspec $ do
    describe "Calibration" $ do
        it "should start at 0" $ do
            calibrate `withInput` "0" `shouldBe` 0
        it "should detect duplicated" $ do
            calibrate `withInput` "+1\n-1\n+1" `shouldBe` 0
            calibrate `withInput` "+3\n+3\n+4\n-2\n-4" `shouldBe` 10
            calibrate `withInput` "-6\n+3\n+8\n+5\n-6" `shouldBe` 5
            calibrate `withInput` "+7\n+7\n-2\n-7\n-4" `shouldBe` 14
